import { createStore } from "vuex";
import createPersistedState from 'vuex-persistedstate'
import modules from "./module.js";

const persistedstate = createPersistedState({
    paths : ['token','id','name','role','nickname']
})

export const store = createStore({
    state:      modules.state,
    getters:    modules.getters,
    mutations:  modules.mutations,
    actions:    modules.actions,
    plugins:    [persistedstate]
})