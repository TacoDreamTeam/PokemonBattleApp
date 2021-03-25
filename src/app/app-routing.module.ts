import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PokemonComponent } from './pokemon/pokemon.component';
import { TrainerDashComponent } from './trainer-dash/trainer-dash.component';
import { TrainerDetailComponent } from './trainer-detail/trainer-detail.component';

const routes: Routes = [
  {path: '', redirectTo: '/trainerDash', pathMatch:'full'},
  { path: 'trainerDash', component: TrainerDashComponent },
  {path: 'trainerInfo', component: TrainerDetailComponent},
  {path: 'pokemon', component: PokemonComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
