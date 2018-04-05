import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FriendsterComponent } from './friendster.component';

describe('FriendsterComponent', () => {
  let component: FriendsterComponent;
  let fixture: ComponentFixture<FriendsterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FriendsterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FriendsterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
