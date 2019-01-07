package com.example.piotrprus.parameterizedviewsample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.piotrprus.parameterizedviewsample.utils.Event

class ParameterizedViewModel: ViewModel() {

    val mainText = MutableLiveData<String>()
    val secondaryText = MutableLiveData<String>()
    val mainButtonText = MutableLiveData<String>()
    val secondaryButtonText = MutableLiveData<String>()
    val mainIcon = MutableLiveData<Int>()

    val mainButtonClickEvent = MutableLiveData<Event<Unit>>()
    val secondaryButtonClickEvent = MutableLiveData<Event<Unit>>()

    fun onMainButtonClicked() {
        mainButtonClickEvent.value = Event(Unit)
    }

    fun onSecondaryButtonClicked() {
        secondaryButtonClickEvent.value = Event(Unit)
    }

    fun bind(params: Params) {
        mainText.value = params.mainText
        secondaryText.value = params.secondaryText
        mainButtonText.value = params.mainButtonText
        secondaryButtonText.value = params.secondaryButtonText
        mainIcon.value = params.mainImageResId
    }
}