package com.example.mobcomp.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobcomp.R
//import com.example.mobcomp.ui.home.categoryPayment.CategoryPayment

@Composable
fun Home(
    viewModel: HomeViewModel= viewModel(),
    navController: NavController
){
   /* val viewState by viewModel.state.collectAsState()*/
   /* val selectedCategory= viewState.selectedCategory*/
                                                                       /**/
   /* if (viewState.categories.isNotEmpty() && selectedCategory != null){*/
   /*     Surface (modifier = Modifier.fillMaxSize()){*/
   /*         HomeContent(*/
   /*             selectedCategory = selectedCategory,*/
   /*             categories = viewState.categories,*/
   /*             onCategorySelected = viewModel::onCategorySelected,*/
   /*             navController = navController*/
   /*         )*/
   /*     }*/
   /* }*/
    HomeContent(navController = navController)

}
// Add icon '+' on home screen view
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeContent(
   // selectedCategory: Category,
   // categories: List<Category>,
    //onCategorySelected: (Category) -> Unit,
    navController: NavController,
){
    Scaffold (
        modifier = Modifier.padding(bottom = 24.dp),
        floatingActionButton ={
            FloatingActionButton(
                onClick = {navController.navigate(route = "reminder")},
                contentColor = Color.Blue,
                modifier= Modifier.padding(all=20.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .systemBarsPadding()
                .fillMaxWidth()
        ){
            val appBarColor = MaterialTheme.colors.secondary.copy(alpha =0.87f)

            HomeAppBar (
                backgroundColor = appBarColor,
                navController = navController
            )
          /*  CategoryTabs(*/
          /*      categories = categories,*/
          /*      selectedCategory = selectedCategory,*/
          /*      onCategorySelected = onCategorySelected,*/
          /*  )*/
          //  CategoryPayment()

        }
    }
}

// top app bar with search and logout icons
@Composable
private fun HomeAppBar(
    backgroundColor:Color,
    navController: NavController
){
    TopAppBar (
        title = {
            Text(
                text = stringResource(R.string.app_name),
                color = MaterialTheme.colors.primary,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .heightIn(max = 24.dp)


            )
        },
        backgroundColor = backgroundColor,
        actions = {
            IconButton( onClick={}) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = stringResource(
                    R.string.search))
            }
            IconButton(onClick = {navController.navigate(route = "login")},) {
                /*Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = (stringResource(
                                    R.string.account)))*/

                Icon(
                    painter = painterResource(id = R.drawable.baseline_logout_24),
                    contentDescription = stringResource(R.string.logout)
                )
            }                                                                                                 

        }
    )
}

/*@Composable*/
/*private fun CategoryTabs(*/
/*    categories: List<Category>,*/
/*    selectedCategory: Category,*/
/*    onCategorySelected: (Category) -> Unit*/
/*){*/
/*    val selectedIndex = categories.indexOfFirst { it == selectedCategory }*/
/*    ScrollableTabRow(*/
/*        selectedTabIndex = selectedIndex,*/
/*        edgePadding = 24.dp,*/
/*        indicator = emptyTabIndicator,*/
/*        modifier = Modifier.fillMaxWidth()*/
/*    ) {*/
/*        categories.forEachIndexed{ index, category ->*/
/*            Tab(*/
/*                selected = index == selectedIndex,*/
/*                onClick = {onCategorySelected(category)}*/
/*            ){*/
/*                ChoiceChipContent(*/
/*                    text = category.name,*/
/*                    selected = index == selectedIndex,*/
/*                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 16.dp)*/
/*                )*/
/*            }*/

//        }

  //  }
//}

/*@Composable*/
/*private  fun ChoiceChipContent  (*/
/*        text: String,*/
/*        selected: Boolean,*/
/*        modifier: Modifier = Modifier*/
/*){*/
    /*Surface(
        color =when{
            selected -> MaterialTheme.colors.secondary.copy(alpha = 0.87f) //Color.White //MaterialTheme.colors.primary.copy(alpha = 0.08f)
            else -> MaterialTheme.colors.onSurface.copy(alpha = 0.12f)
        },
        contentColor = when {
            selected -> Color.Black //MaterialTheme.colors.primary
            else -> MaterialTheme.colors.onSurface
        },
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }*/
//}

private val emptyTabIndicator: @Composable (List<TabPosition>) -> Unit = {}

