object Routes {

    const val PLAN_TRIP = "plan_trip"
    const val LOADING = "loading"
    const val TRIP_DETAILS = "trip_details"
    const val BUDGET_SUMMARY = "budget_summary"
    const val SAVED_TRIPS = "saved_trips"
    const val PROFILE = "profile"

    const val SAVED_TRIP_DETAIL =
        "saved_trip_detail/{city}/{country}/{budget}"

    fun savedTripDetailRoute(
        city: String,
        country: String,
        budget: String
    ): String {
        return "saved_trip_detail/$city/$country/$budget"
    }
}