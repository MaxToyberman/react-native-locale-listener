
var DeviceEventEmitter = require('react-native').DeviceEventEmitter;
const localeDidChangeEvent = 'localeDidChange'
var listeners = {};

var id = 0;
var META = '__listener_id';

function getKey(listener){
  if (!listener.hasOwnProperty(META)){
    if (!Object.isExtensible(listener)) {
      return 'F';
    }
    Object.defineProperty(listener, META, {
      value: 'L' + ++id,
    });
  }
  return listener[META];
};

module.exports = {
  addLocaleListener(cb) {
     var key = getKey(cb);

     listeners[key] = DeviceEventEmitter.addListener(localeDidChangeEvent,
        (body) => {
          cb(body.locale);
        });
  },
  removeLocaleListener(cb) {
    var key = getKey(cb);
    if (!listeners[key]) {
      return;
    }
    listeners[key].remove();
    listeners[key] = null;
  },
}
