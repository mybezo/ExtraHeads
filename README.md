# 🗿 ExtraHeads

<p align="center">
  <a href="https://github.com/mybezo/extraheads/actions/workflows/ci.yml"><img src="https://img.shields.io/github/actions/workflow/status/mybezo/extraheads/ci.yml?branch=master&style=for-the-badge&label=Build" alt="Build status"/></a>
  <a href="LICENSE"><img src="https://img.shields.io/badge/License-MIT-blue?style=for-the-badge" alt="MIT License"/></a>
  <a href="https://discord.gg/fsD4Bkh"><img src="https://img.shields.io/discord/565557184348422174?color=7289DA&label=Discord&style=for-the-badge" alt="Discord"/></a>
</p>

**ExtraHeads** is a [Slimefun4](https://github.com/Slimefun/Slimefun4) addon that adds **84 collectible mob heads** to the game.
Every time a supported mob dies there is a chance it drops its head. Kill it with Slimefun's **Sword of Beheading** to increase that chance.

## ✨ Features

- 🗿 Heads for 84 mobs, from Bats and Blazes to the Warden, Breeze, Creaking, Happy Ghast and Copper Golem
- 🎯 Configurable drop chance per mob (fractional values such as `0.5` are supported)
- ⚔️ Bonus drop chance when using the Slimefun **Sword of Beheading**
- 📖 All heads appear in the Slimefun Guide under the **Extra Heads** category, including each drop chance
- 🧩 Heads are only registered on server versions where the mob exists, so one jar works everywhere

## 📋 Requirements

| Requirement                                                     | Version          |
|-----------------------------------------------------------------|------------------|
| Server ([Paper](https://papermc.io/) or a fork)                 | 1.18 or newer    |
| Java                                                            | 17 or newer      |
| [Slimefun4](https://github.com/Slimefun/Slimefun4)              | latest           |
| [GuizhanLibPlugin](https://github.com/ybw0014/GuizhanLibPlugin) | latest           |

## 📥 Installation

1. Install **Slimefun4** and **GuizhanLibPlugin**.
2. Download ExtraHeads from [the download page](https://resources.guizhanss.com/plugin/ExtraHeads) (or [build it yourself](#-building)).
3. Put the jar in your server's `plugins/` folder.
4. Restart the server.

## ⚙️ Configuration

The config is created at `plugins/ExtraHeads/config.yml` on the first start:

```yaml
options:
  # Automatically download updates (only for official "Build" versions)
  auto-update: true
  # The drop chance is multiplied by this value when the killer holds a Sword of Beheading
  sword-of-beheading-multiplier: 1.8

# Drop chance in percent for every mob. Generated automatically, default 5.0
chances:
  BAT: 5.0
  BLAZE: 5.0
  WARDEN: 0.5
  # ...
```

- A chance of `5.0` means a 5 % drop rate; `100` always drops the head; `0` disables drops for that mob.
- With the default multiplier, the Sword of Beheading turns a 5 % chance into 9 %.
- Individual heads can be disabled completely through Slimefun's `Items.yml`.

## 🐾 Supported mobs

<details>
<summary><b>All versions (48)</b></summary>

Axolotl, Bat, Blaze, Cave Spider, Chicken, Cow, Dolphin, Drowned, Elder Guardian, Enderman, Evoker, Fox, Ghast, Glow Squid, Goat, Guardian, Horse, Husk, Illusioner, Iron Golem, Llama, Magma Cube, Mooshroom, Ocelot, Panda, Parrot, Pig, Piglin, Pillager, Polar Bear, Rabbit, Ravager, Sheep, Shulker, Slime, Spider, Squid, Stray, Strider, Turtle, Vex, Villager, Vindicator, Wandering Trader, Witch, Wither, Zombie Villager, Zombified Piglin

</details>

<details>
<summary><b>1.19+ (22)</b></summary>

Allay, Bee, Cat, Cod, Donkey, Endermite, Frog, Hoglin, Mule, Phantom, Piglin Brute, Pufferfish, Salmon, Silverfish, Skeleton Horse, Snow Golem, Tadpole, Trader Llama, Tropical Fish, Warden, Wolf, Zoglin

</details>

<details>
<summary><b>1.20+ and newer (14)</b></summary>

| Version | Mobs                                                         |
|---------|--------------------------------------------------------------|
| 1.20    | Camel, Sniffer                                               |
| 1.20.5  | Armadillo                                                    |
| 1.21    | Bogged, Breeze                                               |
| 1.21.4  | Creaking                                                     |
| 1.21.6  | Happy Ghast                                                  |
| 1.21.9  | Copper Golem                                                 |
| 1.21.11 | Camel Husk, Nautilus, Parched, Zombie Horse, Zombie Nautilus |
| 26.2    | Sulfur Cube                                                  |

</details>

> Vanilla heads (Zombie, Skeleton, Creeper, Wither Skeleton, Ender Dragon) are not included — the Sword of Beheading in Slimefun already drops those.

## 🔨 Building

You need **JDK 25** installed (the compiled plugin still runs on Java 17+).

```bash
git clone https://github.com/mybezo/extraheads.git
cd extraheads
./gradlew shadowJar
```

The jar is written to `build/libs/`.
To start a local test server with Slimefun and GuizhanLibPlugin preinstalled, run `./gradlew runServer`.

## 🤝 Contributing

Bug reports and pull requests are welcome!

- Found a bug? [Open an issue](../../issues/new/choose).
- Want to add a head? Add a `registerHead(...)` line in [`ItemSetup.java`](src/main/java/io/github/thebusybiscuit/extraheads/setup/ItemSetup.java) with the texture hash from [minecraft-heads.com](https://minecraft-heads.com), guarded by the correct `MinecraftVersionUtil.isAtLeast(...)` check if the mob is not available on 1.18.

## 💬 Community

Join the Slimefun community on Discord to discuss this addon, ask questions or share ideas.

<p align="center">
  <a href="https://discord.gg/fsD4Bkh">
    <img src="https://img.shields.io/discord/565557184348422174?color=7289DA&label=Discord&style=for-the-badge" alt="Discord Invite"/>
  </a>
</p>

## 📜 Credits & License

- Original addon by [TheBusyBiscuit](https://github.com/TheBusyBiscuit), maintained by [ybw0014](https://github.com/ybw0014) and contributors.
- Head textures from [minecraft-heads.com](https://minecraft-heads.com).

This project is licensed under the [MIT License](LICENSE).
