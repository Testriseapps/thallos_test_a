package co.riseapps.androidbaseproject.model

data class SubjectResult (
    var name: String? = null,
    var type: String? = null,
    var score: Int = 0,
    var availabilityAge: Int = 0) {

    fun isAvailableFor (person: Person): Boolean {
        return person.ageMonths >= this.availabilityAge
    }

    companion object {
        const val ADAPTIVE: String = "adaptive"
        const val COGNITION: String = "cognition"
        const val FUNCTIONAL_ACADEMIC: String = "functional_academic"
        const val LANGUAGE_AND_COMMUNICATION: String = "language_&_communication"
        const val MOTOR_SKILLS: String = "motor_skills"
        const val PLAY_SKILLS: String = "play_skils"
        const val SOCIAL_SKILLS: String = "social_skills"
    }
}