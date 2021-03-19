import com.google.gson.annotations.SerializedName

data class Data (

		@SerializedName("user") val user : User,
		@SerializedName("token") val token : String
)