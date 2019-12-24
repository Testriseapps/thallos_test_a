package co.riseapps.androidbaseproject.model.entity

class CountryEntity {
    var name: String? = null
    var denonym: String? = null
    var capital: String? = null
    var alpha2Code: String? = null
    var alpha3Code: String? = null
    var region: String? = null
    var subregion: String? = null
    var population: Int? = null
    var flag: String? = null
    var languages: List<LanguageEntity>? = null
    var currencies: List<CurrencyEntity>? = null
    var timezones: List<String>? = null
    var translations: TranslationEntity? = null
}
