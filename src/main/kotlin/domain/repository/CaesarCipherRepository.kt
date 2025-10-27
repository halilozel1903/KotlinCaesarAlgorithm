package domain.repository

interface CaesarCipherRepository {
    fun encrypt(text: String, shift: Int): String
    fun decrypt(text: String, shift: Int): String
}
