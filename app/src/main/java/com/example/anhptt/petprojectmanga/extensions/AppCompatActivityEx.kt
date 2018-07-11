package com.example.anhptt.petprojectmanga.extensions

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity


fun AppCompatActivity.replaceFragment(fragment: Fragment, containerId: Int) {
    supportFragmentManager.transact { replace(containerId, fragment) }
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, containerId: Int, TAG: String) {
    supportFragmentManager.transact { replace(containerId, fragment, TAG) }
}

private inline fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
    beginTransaction().apply { action() }.commit()
}
