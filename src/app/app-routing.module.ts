import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuardGuard } from './auth/auth-guard.guard';
import { LoginComponent } from './login/login.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { PokemonComponent } from './pokemon/pokemon.component';
import { TrainerDashComponent } from './trainer-dash/trainer-dash.component';
import { TrainerDetailComponent } from './trainer-detail/trainer-detail.component';
import { TrainerTradesComponent } from './trainer-trades/trainer-trades.component';

const routes: Routes = [
  {path: '', redirectTo:'secure', pathMatch: 'full'},
  { path: 'trainerDash', canActivate:[AuthGuardGuard], component: TrainerDashComponent },
  {path: 'trainerInfo', component: TrainerDetailComponent},
  {path: 'trainerTrades', component: TrainerTradesComponent},
  {path: 'pokemon', component: PokemonComponent},
  {path:'login',component:LoginComponent},
  {path: '404', component:NotFoundComponent},
  {path:'**', redirectTo:'404'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
