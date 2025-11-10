package com.outracoisa.melhordetodosn2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.outracoisa.melhordetodosn2.ui.theme.MelhorDeTodosN2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MelhorDeTodosN2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("main") {
            MainScreen()
        }
    }
}

@Composable
fun LoginScreen(navController: NavController) {
    var usuario by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var mensagemErro by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1E1E1E))
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Melhor de Todos",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 48.dp)
        )

        OutlinedTextField(
            value = usuario,
            onValueChange = { usuario = it },
            label = { Text("Usuário") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedBorderColor = Color(0xFF4CAF50),
                unfocusedBorderColor = Color.Gray,
                focusedLabelColor = Color(0xFF4CAF50),
                unfocusedLabelColor = Color.Gray
            ),
            singleLine = true
        )

        OutlinedTextField(
            value = senha,
            onValueChange = { senha = it },
            label = { Text("Senha") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedBorderColor = Color(0xFF4CAF50),
                unfocusedBorderColor = Color.Gray,
                focusedLabelColor = Color(0xFF4CAF50),
                unfocusedLabelColor = Color.Gray
            ),
            singleLine = true
        )

        if (mensagemErro.isNotEmpty()) {
            Text(
                text = mensagemErro,
                color = Color.Red,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        Button(
            onClick = {
                if (usuario.isNotEmpty() && senha.isNotEmpty()) {
                    navController.navigate("main")
                } else {
                    mensagemErro = "Preencha todos os campos"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4CAF50)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "ENTRAR",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun MainScreen() {
    var vencedorSelecionado by remember { mutableStateOf<Pessoa?>(null) }
    
    val pessoas = listOf(
        Pessoa("Guilherme", R.drawable.guilherme),
        Pessoa("Cauã", R.drawable.caua),
        Pessoa("Madu", R.drawable.udam),
        Pessoa("Pablo", R.drawable.boidacarapreta),
        Pessoa("Cachorro", R.drawable.dog)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1E1E1E))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Temos que escolher um novo\nMelhor de Todos!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        if (vencedorSelecionado != null) {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.White, RoundedCornerShape(16.dp))
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = vencedorSelecionado!!.imagemRes),
                    contentDescription = vencedorSelecionado!!.nome,
                    modifier = Modifier.fillMaxSize()
                )
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Text(
                text = "${vencedorSelecionado!!.nome} é o novo\nMelhor de Todos!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4CAF50),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 32.dp)
            )
        } else {
            Spacer(modifier = Modifier.height(100.dp))
        }

        Button(
            onClick = {
                vencedorSelecionado = pessoas.random()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4CAF50)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "ESCOLHER MELHOR DE TODOS",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

data class Pessoa(
    val nome: String,
    val imagemRes: Int
)