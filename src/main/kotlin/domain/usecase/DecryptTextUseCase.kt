package domain.usecase

import domain.repository.CaesarCipherRepository

class DecryptTextUseCase(
    private val repository: CaesarCipherRepository
) {
    operator fun invoke(text: String, shift: Int): String {
        require(shift >= 0) { "Shift value must be non-negative" }
        return repository.decrypt(text, shift)
    }
}
