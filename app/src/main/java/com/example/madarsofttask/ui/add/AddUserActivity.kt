package com.example.madarsofttask.ui.add

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.madarsofttask.R
import com.example.madarsofttask.ui.list.ListUsersActivity
import com.example.madarsofttask.ui.list.ListUsersViewModel
import kotlinx.android.synthetic.main.activity_add_user.*

class AddUserActivity : AppCompatActivity(), OnItemSelectedListener {
    private var userGender: String? = null
    private var addUserViewModel: AddUserViewModel? = null
    private var listUsersViewModel: ListUsersViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)
        initUi()
        name_editText!!.addTextChangedListener(addUserTextWatcher)
        age_editText!!.addTextChangedListener(addUserTextWatcher)
        title_editText!!.addTextChangedListener(addUserTextWatcher)
        initViewModel()
        handleSaveButton()
        handleDisplayButton()
    }

    private val addUserTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
        override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            val usernameInput = name_editText!!.text.toString().trim { it <= ' ' }
            val ageInput = age_editText!!.text.toString().trim { it <= ' ' }
            val titleInput = title_editText!!.text.toString().trim { it <= ' ' }
            save_btn!!.isEnabled = usernameInput.isNotEmpty() && ageInput.isNotEmpty() && titleInput.isNotEmpty()
        }

        override fun afterTextChanged(editable: Editable) {}
    }

    private fun handleDisplayButton() {
        display_button!!.setOnClickListener { startActivity(Intent(this@AddUserActivity, ListUsersActivity::class.java)) }

    }

    private fun handleSaveButton() {
        save_btn!!.setOnClickListener {
            val age = age_editText!!.text.toString().toDouble()
            val name = name_editText!!.text.toString()
            val title = title_editText!!.text.toString()
            val gender = userGender
            addUserViewModel!!.addUser(name, title, age, gender)
            handleUserAdded()
        }
    }

    private fun handleUserAdded() {
        Toast.makeText(this@AddUserActivity, getString(R.string.user_added_successfully), Toast.LENGTH_SHORT).show()
        clearForm()
    }

    private fun clearForm() {
        age_editText!!.setText("")
        name_editText!!.setText("")
        title_editText!!.setText("")
    }

    private fun initViewModel() {
        addUserViewModel = ViewModelProvider(this).get(AddUserViewModel::class.java)
listUsersViewModel=ViewModelProvider(this).get(ListUsersViewModel::class.java)
    }

    private fun initUi() {
        val adapter = ArrayAdapter.createFromResource(this, R.array.genders, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        gender_spinner.adapter = adapter
        gender_spinner.onItemSelectedListener = this
    }

    override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
        userGender = adapterView.getItemAtPosition(i).toString()
    }

    override fun onNothingSelected(adapterView: AdapterView<*>?) {}
}