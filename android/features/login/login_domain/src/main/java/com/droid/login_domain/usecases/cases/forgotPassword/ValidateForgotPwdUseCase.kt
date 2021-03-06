package com.droid.login_domain.usecases.cases.forgotPassword

import android.util.Patterns
import com.droid.login_domain.R
import com.droid.login_domain.usecases.ValidationResult
import com.droid.login_domain.usecases.entities.inputs.ForgotPwdInput
import com.iprayforgod.core.di.qualifiers.IoDispatcher
import com.iprayforgod.core.modules.keys.KeysFeatureNames
import com.iprayforgod.core.modules.logger.repository.LoggerRepository
import com.iprayforgod.core.platform.ui.uiEvent.UiText
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class ValidateForgotPwdUseCase @Inject constructor(
    @IoDispatcher val dispatcher: CoroutineDispatcher,
    private val log: LoggerRepository,
) {

    suspend operator fun invoke(
        input: ForgotPwdInput
    ): Result<ValidationResult> {
        try {
            val result = initiateValidation(input)
            return Result.success(result)
        } catch (ex: Exception) {
            return Result.failure(ex)
        }
    }

    private fun initiateValidation(input: ForgotPwdInput): ValidationResult {
        if (input.email.isBlank()) {
            log.d(KeysFeatureNames.FEATURE_LOGIN, "VALIDATION:-> Email entered is blank")
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(R.string.error_msg_email_cant_be_blank)
            )
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(input.email).matches()) {
            log.d(KeysFeatureNames.FEATURE_LOGIN, "VALIDATION:-> Not valid email format")
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(R.string.error_msg_email_is_not_valid)
            )
        }

        log.d(KeysFeatureNames.FEATURE_LOGIN, "VALIDATION:-> Email validation successful")
        return ValidationResult(
            successful = true
        )
    }
}
