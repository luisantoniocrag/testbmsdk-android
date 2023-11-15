import React, {useEffect, useRef} from 'react';
import { PixelRatio, UIManager,View,findNodeHandle } from 'react-native';
import {BMOrdersViewManager} from '../../modules/BMOrdersViewManager';


const createFragment = (viewId) =>
  UIManager.dispatchViewManagerCommand(
    viewId,
    // we are calling the 'create' command
    UIManager.getViewManagerConfig("BMOrdersViewManager").Commands.create.toString(),

    [viewId],
  );

export default function OrdersScreen({navigation}) {
    const ref = useRef(null);

    useEffect(() => {
        const viewId = findNodeHandle(ref.current);
        createFragment(viewId);
      }, []);
      return (
        <BMOrdersViewManager
                ref={ref}
            />
        
      );
}
