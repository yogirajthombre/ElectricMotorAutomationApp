import com.google.gson.annotations.SerializedName



data class CurrentWaterLevelResponseModel (

		@SerializedName("status") val status : Int,
		@SerializedName("message") val message : String,
		@SerializedName("data") val data : WaterLevels,
		@SerializedName("errors") val errors : Boolean
)