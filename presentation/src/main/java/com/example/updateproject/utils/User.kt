package com.example.updateproject.utils

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.updateproject.BR

class User : BaseObservable() {

    @get:Bindable
    var firstName: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.firstName)
        }

    @get:Bindable
    var lastName: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.lastName)
        }
}
