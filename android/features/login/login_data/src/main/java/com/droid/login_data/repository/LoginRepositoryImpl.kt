package com.droid.login_data.repository

import com.droid.login_data.service.firebase.forgotPwd.ForgotPwdService
import com.droid.login_data.service.firebase.login.LoginService
import com.droid.login_data.service.firebase.registration.RegistrationService
import com.droid.login_domain.usecases.entities.inputs.ForgotPwdInput
import com.droid.login_domain.usecases.entities.inputs.LoginInput
import com.droid.login_domain.usecases.entities.inputs.RegistrationInput
import com.droid.login_domain.usecases.repository.LoginRepository
import com.iprayforgod.core.domain.models.User
import com.iprayforgod.core.platform.functional.State
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val registrationService: RegistrationService,
    private val loginService: LoginService,
    private val forgotPwdService: ForgotPwdService
) : LoginRepository {

    // --> REGISTER the user
    override fun registerUser(input: RegistrationInput): Flow<State<User>> {
        return registrationService.registerUser(input)
    }

    // --> LOGIN the user
    override fun loginUser(input: LoginInput): Flow<State<User>> {
        return loginService.loginUser(input)
    }

    // --> FORGOT-PWD for user
    override fun forgotPassword(input: ForgotPwdInput): Flow<State<Boolean>> {
        return forgotPwdService.forgotPwd(input)
    }
}
