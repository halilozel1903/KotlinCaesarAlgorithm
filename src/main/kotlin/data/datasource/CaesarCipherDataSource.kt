package data.datasource

class CaesarCipherDataSource {
    fun encrypt(text: String, shift: Int): String {
        return text.map { char ->
            if (char.isLetter()) {
                val base = if (char.isUpperCase()) 'A' else 'a'
                val alphabetIndex = char - base
                val normalizedShift = ((shift % ALPHABET_SIZE) + ALPHABET_SIZE) % ALPHABET_SIZE
                val shiftedChar = base + (alphabetIndex + normalizedShift) % ALPHABET_SIZE
                shiftedChar
            } else {
                char
            }
        }.joinToString("")
    }

    fun decrypt(text: String, shift: Int): String {
        val normalizedShift = ((shift % ALPHABET_SIZE) + ALPHABET_SIZE) % ALPHABET_SIZE
        val reverseShift = (ALPHABET_SIZE - normalizedShift) % ALPHABET_SIZE
        return encrypt(text, reverseShift)
    }

    private companion object {
        private const val ALPHABET_SIZE = 26
    }
}
