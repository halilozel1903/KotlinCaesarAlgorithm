package presentation.model

data class CaesarCipherUiState(
    val inputText: String = "",
    val shift: Int = 0,
    val encryptedText: String = "",
    val decryptedText: String = ""
)
