package com.matveyaka.m.m.nigbreathtimer.breathSession.viewModel

import android.os.CountDownTimer
import com.matveyaka.m.m.nigbreathtimer.breathSession.SessionParameters
import com.matveyaka.m.m.nigbreathtimer.breathSession.view.BreathFragment

class breathViewModel {
    val parameters = SessionParameters(
        10,
        2,
        4,
        1,
        1
    )
    val currentParameters = parameters.copy()

    var listener: BreathFragment? = null
    var timer: CountDownTimer? = null



    fun startSession(){
        timer = object : CountDownTimer(
        parameters.sessionLenght * 1000L,
        1000L
        ){
            override fun onTick(p0: Long) {
               updateSession()
               listener?.onChange(currentParameters)
            }

            override fun onFinish() {
                listener?.setStartEnabled(true)
            }
        }
        timer?.start()
        listener?.setStartEnabled(false)
    }

    fun updateSession() {
        currentParameters.sessionLenght -= 1

        if (currentParameters.inhale > 0) {
            currentParameters.inhale -= 1
        } else if (currentParameters.sessionDelay1 > 0) {
            currentParameters.sessionDelay1 -= 1
        } else if (currentParameters.exhale > 0) {
            currentParameters.exhale -= 1
        }  else if (currentParameters.sessionDelay2 > 0) {
            currentParameters.sessionDelay2 -= 1
        }

         if (currentParameters.sessionDelay2 == 0) {
            currentParameters.inhale = parameters.inhale
            currentParameters.exhale = parameters.exhale
            currentParameters.sessionDelay1 = parameters.sessionDelay1
            currentParameters.sessionDelay2 = parameters.sessionDelay2
        }
    }
}