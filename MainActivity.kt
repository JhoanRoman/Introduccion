package co.edu.sena.introduction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.edu.sena.introduction.ui.theme.IntroductionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroductionTheme {
                SimpleMessageScreen()
            }
        }
    }
}

@Composable
fun SimpleMessageScreen(modifier: Modifier = Modifier) {
    val name: String? = "Juan"
    val age: Int? = 20
    var nullableString: String? = null

    val message = if (age != null && age >= 18) {
        "Hola ${name.orEmpty()}, eres mayor de edad."
    } else {
        "Hola ${name.orEmpty()}, eres menor de edad."
    }

    //Ejemplos de control de nulos
    val safeLength = nullableString?.length
    val elvisLength = nullableString?.length ?: 0
    val nonNullAssertion = try {
        nullableString!!.length
    } catch (e: NullPointerException) {
        -1
    }

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = message)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Longitud segura: $safeLength")
        Text(text = "Longitud usando el operador Elvis: $elvisLength")
        Text(text = "Longitud usando el operador de aserción no nula: $nonNullAssertion")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSimpleMessageScreen() {
    IntroductionTheme {
        SimpleMessageScreen()
    }
}
