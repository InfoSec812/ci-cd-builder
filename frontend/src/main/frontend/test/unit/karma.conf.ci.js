// This is a karma config file. For more details see
//   http://karma-runner.github.io/0.13/config/configuration-file.html
// we are also using it with karma-webpack
//   https://github.com/webpack/karma-webpack

var webpackConfig = require('../../build/webpack.test.conf');
var baseConfig = require('./karma.conf');

module.exports = function (config) {
  // Load base config
  baseConfig(config);

  // Override base config
  config.set({
    singleRun: true,
    autoWatch: false
  });
};
