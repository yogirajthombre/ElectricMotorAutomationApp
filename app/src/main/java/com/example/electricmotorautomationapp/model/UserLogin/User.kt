import com.google.gson.annotations.SerializedName

data class User (

		@SerializedName("_id") val _id : String,
		@SerializedName("phoneNumber") val phoneNumber : Int
)