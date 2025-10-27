package org.example

import data.datasource.CaesarCipherDataSource
import data.repository.CaesarCipherRepositoryImpl
import domain.usecase.DecryptTextUseCase
import domain.usecase.EncryptTextUseCase
import presentation.viewmodel.CaesarCipherViewModel

fun main() {
    val dataSource = CaesarCipherDataSource()
    val repository = CaesarCipherRepositoryImpl(dataSource)
    val encryptTextUseCase = EncryptTextUseCase(repository)
    val decryptTextUseCase = DecryptTextUseCase(repository)
    val viewModel = CaesarCipherViewModel(encryptTextUseCase, decryptTextUseCase)

    viewModel.onTextChanged("Taylor Swift")
    viewModel.onShiftChanged(13)
    viewModel.encrypt()

    println("Encrypted: ${viewModel.uiState.encryptedText}")

    viewModel.decryptFromEncrypted()
    println("Decrypted: ${viewModel.uiState.decryptedText}")
}
