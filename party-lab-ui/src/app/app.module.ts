import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {MatTabsModule} from '@angular/material/tabs';

import {AppComponent} from './app.component';
import {ThemeComponent} from './theme/theme.component';
import {ThemeListComponent} from './theme/theme-list/theme-list.component';
import {ThemeEditComponent} from './theme/theme-edit/theme-edit.component';
import {TaskComponent} from './task/task.component';
import {TaskEditComponent} from './task/task-edit/task-edit.component';
import {UserProfileComponent} from './user-profile/user-profile.component';
import {UserProfileListComponent} from './user-profile/user-profile-list/user-profile-list.component';
import {routingModule} from "./routing.module";
import {UserButtonComponent} from "./user-profile/user-button/user-button.component";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {TaskViewMinComponent} from "./task/task-view-min/task-view-min.component";
import {TaskAddButtonComponent} from "./task/task-add-button/task-add-button.component";
import {StartedProjectComponent} from "./started-project/started.project.component";
import {UserTackViewMinComponent} from "./task/user-tack-view-min/user-tack-view-min.component";
import {CommentaryListComponent} from "./commentary/commentary-list/commentary-list.component"
import {CommentaryComponent} from "./commentary/commentary/commentary.component"

@NgModule({
  declarations: [
    AppComponent,
    ThemeComponent,  ThemeListComponent, ThemeEditComponent,
    TaskEditComponent,    TaskComponent, TaskViewMinComponent, TaskAddButtonComponent,
    UserProfileComponent,   UserProfileListComponent, UserButtonComponent, UserTackViewMinComponent,
    StartedProjectComponent,CommentaryListComponent,CommentaryComponent


  ],
  imports: [
    BrowserModule, routingModule, FormsModule, HttpClientModule, BrowserAnimationsModule, MatTabsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
