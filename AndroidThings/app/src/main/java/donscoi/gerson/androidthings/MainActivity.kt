package donscoi.gerson.androidthings

import android.app.Activity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

/**
 * Skeleton of an Android Things activity.
 *
 *
 * Android Things peripheral APIs are accessible through the class
 * PeripheralManagerService. For example, the snippet below will open a GPIO pin and
 * set it to HIGH:
 *
 *
 * <pre>`PeripheralManagerService service = new PeripheralManagerService();
 * mLedGpio = service.openGpio("BCM6");
 * mLedGpio.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
 * mLedGpio.setValue(true);
`</pre> *
 *
 *
 * For more complex peripherals, look for an existing user-space driver, or implement one if none
 * is available.

 * @see [https://github.com/androidthings/contrib-drivers.readme](https://github.com/androidthings/contrib-drivers.readme)
 */
class MainActivity : Activity() {

    val DEFAULT_ANIMATION_DURATION = 1500L

    val MAX_VALUE: Int = 1300


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonAnimate.setOnClickListener({
            var randomInt = Random().nextInt(1300)
            runOnUiThread { textViewDegree.text = randomInt.toString() }
            animate(randomInt)
        })

    }

    private fun animate(sensorValue: Int) {

        var degrees: Float = ((((sensorValue * 100) / MAX_VALUE) * 180) / 100).toFloat()

        val animation: Animation = RotateAnimation(0f, degrees, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 0f)
        animation.duration = DEFAULT_ANIMATION_DURATION
        animation.fillAfter = true

        ponteiro.startAnimation(animation)
    }

}
