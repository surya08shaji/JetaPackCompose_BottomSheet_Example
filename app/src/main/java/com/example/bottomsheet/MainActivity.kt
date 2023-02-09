package com.example.bottomsheet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bottomsheet.ui.theme.BottomSheetTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomSheetTheme {

                val coroutineScope = rememberCoroutineScope()
                val bottomState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
                ModalBottomSheetLayout(
                    sheetState = bottomState,
                    sheetContent = {
                        Spacer(modifier = Modifier.height(1.dp))
                        Text(text = "Hai1", modifier = Modifier.size(36.dp), color = Color.Red)
                        Text(text = "Hai2", modifier = Modifier.size(36.dp), color = Color.Red)
                        Text(text = "Hai3", modifier = Modifier.size(36.dp), color = Color.Red)
                        Text(text = "Hai4", modifier = Modifier.size(36.dp), color = Color.Red)
                        Text(text = "Hai5", modifier = Modifier.size(36.dp), color = Color.Red)
                    }
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(text = "TopAppBar")
                                }
                            )
                        },
                        bottomBar = {
                            BottomAppBar(modifier = Modifier) {
                                IconButton(
                                    onClick = {
                                        coroutineScope.launch { bottomState.show() }
                                    }
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.`in`),
                                        contentDescription = "aa"
                                    )
                                }
                            }
                        },

                        content = { innerPadding ->

                        }
                    )
                }
//                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BottomSheetTheme {
        Greeting("Android")
    }
}