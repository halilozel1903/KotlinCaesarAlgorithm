package data.repository

import data.datasource.CaesarCipherDataSource
import domain.repository.CaesarCipherRepository

class CaesarCipherRepositoryImpl(
    private val dataSource: CaesarCipherDataSource
) : CaesarCipherRepository {

    override fun encrypt(text: String, shift: Int): String =
        dataSource.encrypt(text, shift)

    override fun decrypt(text: String, shift: Int): String =
        dataSource.decrypt(text, shift)
}
