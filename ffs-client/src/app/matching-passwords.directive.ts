import { Directive, Input } from '@angular/core';
import { AbstractControl, NG_VALIDATORS, Validator, ValidatorFn } from '@angular/forms';

/** A hero's name can't match the given regular expression */
export function MatchingPasswordsValidator(otherPassName: string): ValidatorFn {
  return (control: AbstractControl): { [key: string]: any } => {
    const password = control.value;
    const otherPass = control.root.get(otherPassName).value;

    return password !== otherPass ? {matchingPasswords: {value: control.value}} : undefined;
  };
}

@Directive({
  selector: '[appMatchingPasswords]',
  providers: [{provide: NG_VALIDATORS, useExisting: MatchingPasswordsDirective, multi: true}]
})
export class MatchingPasswordsDirective implements Validator {
  @Input('appMatchingPasswords') appMatchingPasswords: string;

  validate(control: AbstractControl): { [key: string]: any } {
    return MatchingPasswordsValidator(this.appMatchingPasswords)(control);
  }

}
