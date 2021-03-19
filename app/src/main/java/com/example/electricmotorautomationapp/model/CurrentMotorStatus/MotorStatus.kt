import com.google.gson.annotations.SerializedName

data class MotorStatus (

	@SerializedName("isMotorRunning") val isMotorRunning : Boolean
)