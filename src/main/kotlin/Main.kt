package org.example

fun caesarCipher(text: String, key: Int) = text.map { char ->
    if (char.isLetter()) {
        val shiftedChar = 'a' + (char.lowercaseChar() - 'a' + key) % 26
        if (char.isUpperCase()) shiftedChar.uppercaseChar() else shiftedChar
    } else {
        char
    }
}.joinToString("")

fun caesarDecipher(text: String, key: Int) = caesarCipher(text, 26 - key % 26)

fun main() {
    val message = "Taylor Swift"
    val key = 3

    val encrypted = caesarCipher(message, key)
    println("Encrypted: $encrypted")

    val decrypted = caesarDecipher(encrypted, key)
    println("Decrypted: $decrypted")
}
