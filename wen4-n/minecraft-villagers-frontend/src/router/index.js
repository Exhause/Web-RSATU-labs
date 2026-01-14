import Vue from "vue";
import VueRouter from "vue-router";
import VillagesView from "../views/VillagesView.vue";
import VillageView from "../views/VillageView.vue";
import VillagerView from "../views/VillagerView.vue";
import ItemsView from "../views/ItemsView.vue";
import DealsView from "../views/DealsView.vue";

Vue.use(VueRouter);

const router = new VueRouter({
  mode: "history",
  base: import.meta.env.BASE_URL,
  routes: [
    {
      path: "/",
      name: "root",
      component: VillagesView,
    },
    {
      path: "/villages",
      name: "villages",
      component: VillagesView,
    },
    {
      path: "/villages/:id",
      name: "village",
      component: VillageView,
      props: true,
    },
    {
      path: "/villagers/:id",
      name: "villager",
      component: VillagerView,
      props: true,
    },
    {
      path: "/items",
      name: "items",
      component: ItemsView,
    },
    {
      path: "/deals",
      name: "deals",
      component: DealsView,
    },
  ],
});

export default router;
