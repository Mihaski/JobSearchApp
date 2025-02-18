package com.example.jobsearchapp.utils

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class FragmentViewBindingDelegate<T : ViewBinding>(
    private val fragment: Fragment,
    val viewBindingFactory: (View) -> T,
) : ReadOnlyProperty<Fragment, T> {

    init {
        fragment.lifecycle.addObserver(object : DefaultLifecycleObserver {                          // fragment.lifecycle.addObserver(object : LifecycleEventObserver {
            override fun onCreate(owner: LifecycleOwner) {                                          //override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                fragment.viewLifecycleOwnerLiveData.observe(fragment) { viewLifecycleOwner ->       //if (event == Lifecycle.Event.ON_CREATE) {
                    viewLifecycleOwner.lifecycle.addObserver(object : DefaultLifecycleObserver {    //fragment.viewLifecycleOwnerLiveData.observe(fragment, Observer { lifecycleOwner ->
                        override fun onDestroy(owner: LifecycleOwner) {                             //lifecycleOwner.lifecycle.addObserver(object: LifecycleEventObserver {
                            _binding = null                                                         //override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                        }                                                                           //if (event == Lifecycle.Event.ON_DESTROY) {
                    })                                                                              //_binding = null
                }   //}
            }   //}
        })  //})
    }   //}
        //}
        //})

    private var _binding: T? = null
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        val binding = _binding
        if (binding != null) {
            return binding
        }

        val lifecycle = fragment.viewLifecycleOwner.lifecycle
        if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
            throw IllegalStateException("Should not attempt to get bindings when Fragment views are destroyed.")
        }
        return viewBindingFactory(thisRef.requireView()).also { _binding = it }
    }
}

fun <T : ViewBinding> Fragment.viewBinding(viewBindingFactory: (View) -> T) =
    FragmentViewBindingDelegate(this, viewBindingFactory)