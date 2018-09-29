import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent} from './app.component';
import { ThemeComponent } from './theme/theme.component';
import { ThemeListComponent } from './theme/theme-list/theme-list.component';
import { ThemeEditComponent } from './theme/theme-edit/theme-edit.component';
import { TaskComponent } from './task/task.component';
import { TaskEditComponent } from './task/task-edit/task-edit.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { UserProfileListComponent } from './user-profile/user-profile-list/user-profile-list.component';
import { routingModule } from "./routing.module";
import { LoginComponent } from "./login/login.component";


@NgModule({
  declarations: [
    AppComponent,
    ThemeComponent,  ThemeListComponent, ThemeEditComponent,
    TaskEditComponent,    TaskComponent,
    UserProfileComponent,   UserProfileListComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule, routingModule, FormsModule, HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
