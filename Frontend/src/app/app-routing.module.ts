import { PreCatchComponent } from './pre-catch/pre-catch.component';
import { CatchComponent } from './catch/catch.component';
import { PreBattleComponent } from './pre-battle/pre-battle.component';
import { BattleComponent } from './battle/battle.component';
import { TrainerDeckComponent } from './trainer-deck/trainer-deck.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth/auth.guard';
import { LoginComponent } from './login/login.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { PokemonComponent } from './pokemon/pokemon.component';
import { RegisterComponent } from './register/register.component';
import { TrainerDashComponent } from './trainer-dash/trainer-dash.component';
import { TrainerDetailComponent } from './trainer-detail/trainer-detail.component';
import { TrainerTradesComponent } from './trainer-trades/trainer-trades.component';



const routes: Routes = [
  {path: '', redirectTo:'trainerDash', pathMatch: 'full'},
  { path: 'trainerDash', component: TrainerDashComponent},
  {path: 'trainerInfo', component: TrainerDetailComponent},
  {path: 'trainerTrades', component: TrainerTradesComponent},
  {path: 'trainerDeck', component: TrainerDeckComponent},
  {path: 'pokemon', component: PokemonComponent},
  {path:'login',component:LoginComponent},
  {path:'register',component: RegisterComponent},
  {path:'battle', component:BattleComponent},
  {path:'preBattle', component:PreBattleComponent},
  {path:'catch', component:CatchComponent},
  {path:'preCatch', component:PreCatchComponent},
  {path: '404', component:NotFoundComponent},
  {path:'**', redirectTo:'404'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
