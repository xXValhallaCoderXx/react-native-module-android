import React from 'react';
import {
  SafeAreaView,
  ScrollView,
  StatusBar,
  Button,
  View,
  NativeModules,
} from 'react-native';

import {Colors, Header} from 'react-native/Libraries/NewAppScreen';
const {OurModule} = NativeModules;

const App = () => {
  const onPress = () => {
    OurModule.openToast('Hello Java from JS');
  };
  return (
    <SafeAreaView style={Colors.darker}>
      <StatusBar barStyle="light-content" />
      <ScrollView
        contentInsetAdjustmentBehavior="automatic"
        style={Colors.darker}>
        <Header />
        <View
          style={{
            backgroundColor: Colors.black,
          }}>
          <Button title="OPEN TOAST" onPress={onPress} />
        </View>
      </ScrollView>
    </SafeAreaView>
  );
};

export default App;
