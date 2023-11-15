import React, {useEffect, useRef} from 'react';
import { PixelRatio, UIManager,View,findNodeHandle } from 'react-native';
import {BMAuthViewManager} from '../../modules/BMAuthViewManager';


const createFragment = (viewId) =>
  UIManager.dispatchViewManagerCommand(
    viewId,
    // we are calling the 'create' command
    UIManager.getViewManagerConfig("BMAuthViewManager").Commands.create.toString(),

    [viewId],
  );

export default function AuthScreen({navigation}) {
    const ref = useRef(null);

    useEffect(() => {
        const viewId = findNodeHandle(ref.current);
        createFragment(viewId);
      }, []);
      return (
        <BMAuthViewManager ref={ref} /> 
      );
}
