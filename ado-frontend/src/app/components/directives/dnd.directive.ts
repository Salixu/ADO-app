import { Directive, EventEmitter, HostBinding, HostListener, Output } from '@angular/core';
import {DomSanitizer, SafeUrl } from '@angular/platform-browser';

export interface FileHandle {
  file: File;
  url: SafeUrl;
}


@Directive({
  selector: '[appDnd]'
})
export class DndDirective {

  @Output() files: EventEmitter<FileHandle> = new EventEmitter();

  @HostBinding('style.background') private background = 'linear-gradient(180deg, rgba(0,173,181,0) 0%, rgba(0,173,181,0.4009978991596639) 100%)';

  constructor(private sanitizer: DomSanitizer) { }

  @HostListener('dragover', ['$event']) public onDragOver(evt: DragEvent) {
    evt.preventDefault();
    evt.stopPropagation();
    this.background = 'linear-gradient(0deg, rgba(0,173,181,0) 0%, rgba(0,173,181,1) 100%)';
  }

  @HostListener('dragleave', ['$event']) public onDragLeave(evt: DragEvent) {
    evt.preventDefault();
    evt.stopPropagation();
    this.background = 'linear-gradient(180deg, rgba(0,173,181,0) 0%, rgba(0,173,181,0.4009978991596639) 100%)';
  }

  @HostListener('change', ['$event.target.files']) emitFiles( event: FileList ) {
    const files: FileHandle [] = [];

    const file = event.item(0);
    const url = this.sanitizer.bypassSecurityTrustUrl(window.URL.createObjectURL(file));
    files.push({ file, url });

    if (files.length > 0) {
      this.files.emit(files[0]);
    }
  }

  @HostListener('drop', ['$event']) public onDrop(evt: DragEvent) {
    evt.preventDefault();
    evt.stopPropagation();
    this.background = 'linear-gradient(180deg, rgba(0,173,181,0) 0%, rgba(0,173,181,0.4009978991596639) 100%)';

    const files: FileHandle [] = [];

    const file = evt.dataTransfer.files[0];
    const url = this.sanitizer.bypassSecurityTrustUrl(window.URL.createObjectURL(file));
    files.push({ file, url });

    if (files.length > 0) {
      this.files.emit(files[0]);
    }
  }

}
