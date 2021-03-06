import { TrainerDeckComponent } from './trainer-deck/trainer-deck.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatToolbarModule } from '@angular/material/toolbar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatGridListModule } from '@angular/material/grid-list';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { TrainerDetailComponent } from './trainer-detail/trainer-detail.component';
import { MatIconModule } from '@angular/material/icon';
import { PokemonComponent } from './pokemon/pokemon.component';
import { TrainerDashComponent } from './trainer-dash/trainer-dash.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { PokemonDetailComponent } from './pokemon-detail/pokemon-detail.component';
import { MessageComponent } from './message/message.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { MatPaginatorModule } from '@angular/material/paginator';
import { RegisterComponent } from './register/register.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { LoginComponent } from './login/login.component';
import { TrainerTradesComponent } from './trainer-trades/trainer-trades.component';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { CommonModule } from '@angular/common';
import { BattleComponent } from './battle/battle.component';
import { PreBattleComponent } from './pre-battle/pre-battle.component';
import { CatchComponent } from './catch/catch.component';
import { PreCatchComponent } from './pre-catch/pre-catch.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    TrainerDetailComponent,
    PokemonComponent,
    TrainerDashComponent,
    PokemonDetailComponent,
    MessageComponent,
    RegisterComponent,
    NotFoundComponent,
    LoginComponent,
    TrainerTradesComponent,
    TrainerDeckComponent,
    BattleComponent,
    PreBattleComponent,
    CatchComponent,
    PreCatchComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatGridListModule,
    MatButtonModule,
    MatCardModule,
    MatIconModule,
    HttpClientModule,
    MatFormFieldModule,
    FormsModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    MatPaginatorModule,
    CommonModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
