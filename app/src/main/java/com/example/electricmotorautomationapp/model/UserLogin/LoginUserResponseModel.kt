import com.google.gson.annotations.SerializedName


data class LoginUserResponseModel (

        @SerializedName("status") val status : Int,
        @SerializedName("message") val message : String,
        @SerializedName("data") val data : Data,
        @SerializedName("errors") val errors : Boolean
)