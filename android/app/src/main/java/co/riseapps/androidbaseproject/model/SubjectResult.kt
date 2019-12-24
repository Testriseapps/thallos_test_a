package co.riseapps.androidbaseproject.model

data class SubjectResult (
    var name: String? = null,
    var picture: String? = null,
    var score: Int = 0,
    var availabilityAge: Int = 0) {

    fun isAvailableFor (person: Person): Boolean {
        return person.ageMonths >= this.availabilityAge
    }
}