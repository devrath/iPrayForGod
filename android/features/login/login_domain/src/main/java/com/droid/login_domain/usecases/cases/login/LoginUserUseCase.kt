package com.droid.login_domain.usecases.cases.login

import com.droid.login_domain.usecases.entities.inputs.LoginInput
import com.droid.login_domain.usecases.repository.LoginRepository
import com.iprayforgod.core.domain.models.User
import com.iprayforgod.core.platform.functional.State
import kotlinx.coroutines.flow.Flow

class LoginUserUseCase(
    private val loginRepo: LoginRepository
) {

    operator fun invoke(input: LoginInput): Flow<State<User>> {
        return loginRepo.loginUser(input)
    }
}
