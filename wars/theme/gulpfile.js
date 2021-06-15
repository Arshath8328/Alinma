'use strict';

var gulp = require('gulp');
const eslint = require('gulp-eslint');
var liferayThemeTasks = require('liferay-theme-tasks');

liferayThemeTasks.registerTasks({
	gulp: gulp
});
