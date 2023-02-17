package com.example.mobcomp.ui.reminder

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import java.util.*


@Composable
fun Reminder(
    onBackPress: () -> Unit,
   viewModel: ReminderViewModel = viewModel()
) {
  //  val viewState by viewModel.state.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    val message = rememberSaveable { mutableStateOf("") }
    val date = rememberSaveable { mutableStateOf("") }
    Surface {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
        ) {
            TopAppBar {
                IconButton (
                    onClick = onBackPress
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null
                    )

                }
                Text(text = "Home")

            }
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement  = Arrangement.Top,
                modifier = Modifier.padding (16.dp)
            ) {
                OutlinedTextField(
                    value = message.value,
                    onValueChange = {message.value=it},
                    label = { Text("Reminder message...") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    keyboardOptions = KeyboardOptions.Default
                )
                Spacer(modifier = Modifier.height(10.dp))
                // add date picker here
                OutlinedTextField(
                    value = date.value,
                    onValueChange = {date.value=it},
                    label = {Text(text="Date")},
                    modifier = Modifier.fillMaxWidth()

                )
                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    enabled = true,
                    onClick = {
                              coroutineScope.launch {
                                  viewModel.saveReminder(
                                      com.example.mobcomp.data.entity.Reminder(
                                          reminderMessage = message.value,
                                          reminderDate = Date().time
                                      )
                                  )
                              }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(55.dp)
                ){
                    Text("Save Reminder")

                }
            }
        }
    }
}
