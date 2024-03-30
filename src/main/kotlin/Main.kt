package org.example

fun caesarCipher(text: String, key: Int): String {
    val alphabet = "abcdefghijklmnopqrstuvwxyz"
    val shiftedAlphabet = alphabet.substring(key % 26) + alphabet.substring(0, key % 26)

    val encryptedText = text.map { char ->
        if (char.isLetter()) {
            val index = alphabet.indexOf(char.toLowerCase())
            val newIndex = (index + key) % 26
            shiftedAlphabet[newIndex]
        } else {
            char
        }
    }.joinToString("")

    return encryptedText
}

fun caesarDecipher(text: String, key: Int): String {
    return caesarCipher(text, 26 - key % 26)
}

fun main() {
    val message = "Shakira"
    val key = 3

    val encryptedMessage = caesarCipher(message, key)
    println("Şifreli mesaj: $encryptedMessage")

    val decryptedMessage = caesarDecipher(encryptedMessage, key)
    println("Çözülmüş mesaj: $decryptedMessage")
}
