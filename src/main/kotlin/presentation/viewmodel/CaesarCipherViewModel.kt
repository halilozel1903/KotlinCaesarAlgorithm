package presentation.viewmodel

import domain.usecase.DecryptTextUseCase
import domain.usecase.EncryptTextUseCase
import presentation.model.CaesarCipherUiState

class CaesarCipherViewModel(
    private val encryptTextUseCase: EncryptTextUseCase,
    private val decryptTextUseCase: DecryptTextUseCase
) {

    private var _uiState: CaesarCipherUiState = CaesarCipherUiState()
    val uiState: CaesarCipherUiState
        get() = _uiState

    fun onTextChanged(text: String) {
        _uiState = _uiState.copy(inputText = text)
    }

    fun onShiftChanged(shift: Int) {
        require(shift >= 0) { "Shift value must be non-negative" }
        _uiState = _uiState.copy(shift = shift)
    }

    fun encrypt() {
        val encrypted = encryptTextUseCase(_uiState.inputText, _uiState.shift)
        _uiState = _uiState.copy(encryptedText = encrypted)
    }

    fun decryptFromEncrypted() {
        val decrypted = decryptTextUseCase(_uiState.encryptedText, _uiState.shift)
        _uiState = _uiState.copy(decryptedText = decrypted)
    }

    fun decryptFromInput() {
        val decrypted = decryptTextUseCase(_uiState.inputText, _uiState.shift)
        _uiState = _uiState.copy(decryptedText = decrypted)
    }
}
