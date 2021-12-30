import {combineReducers} from 'redux';
import transactionReducer from './transaction/transactionReducer';

const rootReducer = combineReducers({
    transaction: transactionReducer
});

export default rootReducer;