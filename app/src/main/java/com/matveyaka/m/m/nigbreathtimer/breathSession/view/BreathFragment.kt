package com.matveyaka.m.m.nigbreathtimer.breathSession.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.matveyaka.m.m.nigbreathtimer.R
import com.matveyaka.m.m.nigbreathtimer.breathSession.SessionParameters
import com.matveyaka.m.m.nigbreathtimer.breathSession.viewModel.breathViewModel

class BreathFragment: Fragment() {
    private val viewModel: breathViewModel = breathViewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_breath_session,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listener = this

        val vdoh = view.findViewById<TextView>(R.id.textView6)
        val zadershka = view.findViewById<TextView>(R.id.textView2)
        val vdoh2 = view.findViewById<TextView>(R.id.textView8)
        val zadershka2 = view.findViewById<TextView>(R.id.textView9)

        vdoh.text = viewModel.parameters.inhale.toString()
        vdoh2.text = viewModel.parameters.inhale.toString()
        zadershka.text = viewModel.parameters.inhale.toString()
        zadershka2.text = viewModel.parameters.inhale.toString()

        view.findViewById<Button>(R.id.start_button).setOnClickListener {
            viewModel.startSession()
        }



        val startbutton = view.findViewById<Button>(R.id.start_button)
        startbutton.setOnClickListener {
            println("STASIK NORMALEK PAREN'")
        }
    }
    fun onChange(newValues: SessionParameters){
        val vdoh = view?.findViewById<TextView>(R.id.textView6)
        val zadershka = view?.findViewById<TextView>(R.id.textView2)
        val vdoh2 = view?.findViewById<TextView>(R.id.textView8)
        val zadershka2 = view?.findViewById<TextView>(R.id.textView9)

        vdoh?.text = newValues.inhale.toString()
        vdoh2?.text = newValues.inhale.toString()
        zadershka?.text = newValues.inhale.toString()
        zadershka2?.text = newValues.inhale.toString()

    }

    fun setStartEnabled(value : Boolean) {
        view?.findViewById<Button>(R.id.start_button)?.isEnabled = value

    }
}