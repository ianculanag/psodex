import {combineReducers} from 'redux';
import transactionReducer from './transaction/transactionReducer';
import accountReducer from './account/accountReducer';

const rootReducer = combineReducers({
    transaction: transactionReducer,
    account: accountReducer
});

export default rootReducer;