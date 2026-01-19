import Vue from "vue";
import VueRouter from "vue-router";
import VillagesView from "../views/VillagesView.vue";
import VillageView from "../views/VillageView.vue";
import VillagerView from "../views/VillagerView.vue";
import ItemsView from "../views/ItemsView.vue";
import DealsView from "../views/DealsView.vue";
import CreateItemView from "../views/CreateItemView.vue";
import UpdateItemView from "../views/UpdateItemView.vue";
import CreateDealView from "../views/CreateDealView.vue";
import UpdateDealView from "../views/UpdateDealView.vue";
import CreateVillageView from "../views/CreateVillageView.vue";
import UpdateVillageView from "../views/UpdateVillageView.vue";
import CreateVillagerView from "../views/CreateVillagerView.vue";
import UpdateVillagerView from "../views/UpdateVillagerView.vue";
import AddDealToVillagerView from "../views/AddDealToVillagerView.vue";

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
      path: "/villages/create",
      name: "create village",
      component: CreateVillageView,
    },
    {
      path: "/villages/:id/update",
      name: "update village",
      component: UpdateVillageView,
      props: true,
    },
    {
      path: "/villages/:id",
      name: "village",
      component: VillageView,
      props: true,
    },
    {
      path: "/villages/:villageId/villagers/create",
      name: "create villager",
      component: CreateVillagerView,
      props: true,
    },
    {
      path: "/villages/:villageId/villagers/:id/update",
      name: "update villager",
      component: UpdateVillagerView,
      props: true,
    },
    {
      path: "/villagers/:id/deals/add",
      name: "add deal to villager",
      component: AddDealToVillagerView,
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
      path: "/items/create",
      name: "create item",
      component: CreateItemView,
    },
    {
      path: "/items/:id/update",
      name: "update item",
      component: UpdateItemView,
      props: true,
    },
    {
      path: "/deals",
      name: "deals",
      component: DealsView,
    },
    {
      path: "/deals/create",
      name: "create deal",
      component: CreateDealView,
    },
    {
      path: "/deals/:id/update",
      name: "update deal",
      component: UpdateDealView,
      props: true,
    },
  ],
});

export default router;
